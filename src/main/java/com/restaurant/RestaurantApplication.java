package com.restaurant;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import com.restaurant.patterns.facade.RestaurantFacade;
import com.restaurant.models.*;
import com.restaurant.ui.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * RESTAURANT MANAGEMENT SYSTEM - MAIN APPLICATION LOGIC
 * Contains all UI setup and business logic implementation
 */
public class RestaurantApplication extends Application {

    private RestaurantFacade restaurant;
    private BorderPane mainLayout;
    private TextArea notificationArea;
    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) {
        System.out.println("🚀 Starting Restaurant Management System...");

        // 🎭 FACADE PATTERN - единая точка входа в систему
        restaurant = new RestaurantFacade();

        primaryStage.setTitle("RestaurantPro - 6 Design Patterns Demo");

        mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));

        // Создаем интерфейс
        mainLayout.setTop(createTopBar());
        mainLayout.setLeft(createLeftMenu());
        mainLayout.setRight(createNotificationPanel());
        mainLayout.setBottom(createBottomBar());

        // По умолчанию показываем дашборд
        showDashboard();

        Scene scene = new Scene(mainLayout, 1400, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

        addNotification("✅ System started with 6 design patterns");
        addNotification("🔨 Builder 🏭 Factory 💵 Strategy 🎨 Decorator 👁️ Observer 🎭 Facade");
    }

    // ========== UI COMPONENTS ==========

    private HBox createTopBar() {
        HBox topBar = new HBox(20);
        topBar.setPadding(new Insets(15));
        topBar.setStyle("-fx-background-color: #2c3e50;");
        topBar.setAlignment(Pos.CENTER_LEFT);

        Label title = new Label("🍽️ RestaurantPro - 6 Patterns Demo");
        title.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-font-weight: bold;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topBar.getChildren().addAll(title, spacer);
        return topBar;
    }

    private VBox createLeftMenu() {
        VBox menu = new VBox(10);
        menu.setPadding(new Insets(10));
        menu.setPrefWidth(250);
        menu.setStyle("-fx-background-color: #34495e;");

        String[] menuItems = {
                "📊 Dashboard",
                "🪑 Tables",
                "📝 Create Order",
                "📋 Manage Orders",
                "🍕 Menu",
                "👥 Staff",
                "👥 Customers",
                "📈 Reports"
        };

        for (String item : menuItems) {
            Button btn = new Button(item);
            btn.setPrefWidth(230);
            btn.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 14px;");

            switch (item) {
                case "📊 Dashboard":
                    btn.setOnAction(e -> showDashboard());
                    break;
                case "🪑 Tables":
                    btn.setOnAction(e -> showTablesPanel());
                    break;
                case "📝 Create Order":
                    btn.setOnAction(e -> showOrderPanel());
                    break;
                case "📋 Manage Orders":
                    btn.setOnAction(e -> showOrderManagementPanel());
                    break;
                case "🍕 Menu":
                    btn.setOnAction(e -> showMenuPanel());
                    break;
                case "👥 Staff":
                    btn.setOnAction(e -> showStaffPanel());
                    break;
                case "👥 Customers":
                    btn.setOnAction(e -> showCustomerPanel());
                    break;
                case "📈 Reports":
                    btn.setOnAction(e -> showReportsPanel());
                    break;
            }

            menu.getChildren().add(btn);
        }

        return menu;
    }

    private VBox createNotificationPanel() {
        VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));
        panel.setPrefWidth(300);

        Label title = new Label("🔔 Pattern Demonstrations");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        notificationArea = new TextArea();
        notificationArea.setEditable(false);
        notificationArea.setWrapText(true);
        notificationArea.setPrefHeight(700);

        panel.getChildren().addAll(title, notificationArea);
        return panel;
    }

    private HBox createBottomBar() {
        HBox bottomBar = new HBox(20);
        bottomBar.setPadding(new Insets(10));
        bottomBar.setStyle("-fx-background-color: #2c3e50;");

        statusLabel = new Label("6 Design Patterns Active: 🔨🏭💵🎨👁️🎭");
        statusLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        bottomBar.getChildren().add(statusLabel);
        return bottomBar;
    }

    // ========== SCREEN NAVIGATION ==========

    private void showDashboard() {
        VBox dashboard = new VBox(20);
        dashboard.setPadding(new Insets(25));

        Label title = new Label("🎯 Restaurant Management System");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        Label patterns = new Label("Implemented Design Patterns:");
        patterns.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        VBox patternsList = new VBox(10);
        String[] patternDetails = {
                "🔨 BUILDER - Step-by-step order creation",
                "🏭 FACTORY - Dish creation based on category",
                "💵 STRATEGY - Flexible pricing algorithms",
                "🎨 DECORATOR - Dynamic dish customization",
                "👁️ OBSERVER - Real-time notifications",
                "🎭 FACADE - Simplified system interface"
        };

        for (String detail : patternDetails) {
            Label label = new Label(detail);
            label.setStyle("-fx-font-size: 14px;");
            patternsList.getChildren().add(label);
        }

        Button demoBtn = new Button("🎬 Run Pattern Demonstrations");
        demoBtn.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-size: 16px;");
        demoBtn.setOnAction(e -> com.restaurant.ui.PatternTests.runAllTests());

        dashboard.getChildren().addAll(title, patterns, patternsList, demoBtn);
        mainLayout.setCenter(dashboard);

        addNotification("📊 Viewing dashboard");
    }

    private void showTablesPanel() {
        TablesPanel tablesPanel = new TablesPanel(restaurant, this::addNotification);
        mainLayout.setCenter(tablesPanel);
        addNotification("🪑 Table management - Click tables to occupy/free");
    }

    private void showOrderPanel() {
        OrderPanel orderPanel = new OrderPanel(restaurant, this::addNotification);
        mainLayout.setCenter(orderPanel);
        addNotification("📝 Order creation panel loaded");
    }

    private void showOrderManagementPanel() {
        OrderManagementPanel panel = new OrderManagementPanel(restaurant, this::addNotification);
        mainLayout.setCenter(panel);
        addNotification("📋 Order management - Track and update order status");
    }

    private void showMenuPanel() {
        MenuPanel menuPanel = new MenuPanel(restaurant, this::addNotification);
        mainLayout.setCenter(menuPanel);
        addNotification("🍕 Menu management - Factory and Decorator patterns");
    }

    private void showStaffPanel() {
        StaffPanel staffPanel = new StaffPanel(restaurant, this::addNotification);
        mainLayout.setCenter(staffPanel);
        addNotification("👥 Staff management - Observer pattern for notifications");
    }

    private void showCustomerPanel() {
        CustomerPanel customerPanel = new CustomerPanel(this::addNotification);
        mainLayout.setCenter(customerPanel);
        addNotification("👥 Customer management panel loaded");
    }

    private void showReportsPanel() {
        ReportsPanel reportsPanel = new ReportsPanel(restaurant, this::addNotification);
        mainLayout.setCenter(reportsPanel);
        addNotification("📈 Reports - Facade pattern provides simplified reporting");
    }

    // ========== UTILITY METHODS ==========

    /**
     * Добавляет уведомление в панель с временной меткой
     */
    public void addNotification(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        notificationArea.appendText("[" + timestamp + "] " + message + "\n");
    }

    /**
     * Показывает alert с заголовком и сообщением
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Getter for RestaurantFacade (for potential future extensions)
     */
    public RestaurantFacade getRestaurantFacade() {
        return restaurant;
    }
}