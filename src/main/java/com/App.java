package com;

import com.service.ProductionModels;

public class App {
    public static void main(String[] args) {
        ProductionModels productionModels = new ProductionModels();
        productionModels.initForTask1();
        productionModels.straightRun();
    }
}
