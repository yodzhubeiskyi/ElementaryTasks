package com.oessoft.output;

import com.oessoft.model.Triangle;
import com.oessoft.service.MainMenuService;
import com.oessoft.service.TriangleService;

import java.util.List;

public class TriangleOutput {
    private List<Triangle> listOfTriangles;

    public TriangleOutput(TriangleService triangleService) {
        listOfTriangles = triangleService.getListOfTriangles();
    }

    public void printListOfTriangles() {
        System.out.println("============= Triangles list: =============");
        for (Triangle triangle : listOfTriangles) {
            String formattedTriangleArea = String.format("%.2f", triangle.getArea());
            StringBuilder outputBuilder = new StringBuilder();
            outputBuilder.append(listOfTriangles.indexOf(triangle) + 1).append(". [Triangle ")
                    .append(triangle.getName()).append("]: ").append(formattedTriangleArea)
                    .append(" cm");
            System.out.println(outputBuilder);
        }
        MainMenuService.showTaskSelection();
    }
}
