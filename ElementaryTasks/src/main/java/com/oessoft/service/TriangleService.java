package com.oessoft.service;

import com.oessoft.input.ParameterInput;
import com.oessoft.input.TriangleInput;
import com.oessoft.model.Triangle;

import java.util.*;

public class TriangleService {
    private List<Triangle> listOfTriangles = new ArrayList<>();

    public TriangleService() {
        boolean inputMoreTriangles = true;
        do {
            Triangle triangle = createTriangle();
            listOfTriangles.add(triangle);
            inputMoreTriangles = askForMoreTriangles();
        } while (inputMoreTriangles);
        sortTrianglesByDescendingArea(listOfTriangles);
    }

    public Triangle createTriangle() {
        TriangleInput triangleInput = new TriangleInput();
        return triangleInput.getTriangle();
    }

    public boolean askForMoreTriangles() {
        System.out.println("Input another triangle? (type 'y' or 'yes' to confirm)");
        String userResponse = ParameterInput.getStringParameterFromConsole();
        userResponse.toLowerCase();
        if (userResponse.equals("y") || userResponse.equals("yes")) {
            return true;
        }
        return false;
    }

    public List<Triangle> sortTrianglesByDescendingArea(List<Triangle> ListOfTriangles) {
        ListOfTriangles.sort((Triangle t1, Triangle t2)-> (int) (t2.getArea()-t1.getArea()));
        return listOfTriangles;
    }

    public List<Triangle> getListOfTriangles() {
        return  listOfTriangles;
    }
}
