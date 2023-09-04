package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        Double weight = Double.parseDouble(request.getParameter("weight"));
        Double height = Double.parseDouble(request.getParameter("height"));

        //TODO: calculate bmi

        Double bmi = weight / (height * height);
        
        long bmilong = Math.round(bmi); 



        //TODO: determine the built from BMI
        String BMI ="";{
            if(bmi <= 18.5){
                BMI = "underweight";
            } else if(bmi <= 25){
                BMI = "normal";
            } else if (bmi <= 30){
                BMI = "overweight";
            } else if (bmi <=35){
                BMI = "obese";

            }  else {
                BMI = "extremely obese";
            }
        }
      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmilong);
        request.setAttribute("built", BMI);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
           
    }
    
}
