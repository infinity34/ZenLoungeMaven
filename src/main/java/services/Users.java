package services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.UsersController;
import utilitaries.ErrorMessage;
import utilitaries.Rest;

/**
 * Servlet implementation class Users
 */
@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object responseObject = null;
		HashMap<String,String> parameters = Rest.GetParameters(request);
		if(parameters.get("id") != null){
			int id = 0;
			try{
				id = Integer.parseInt(parameters.get("id"));
				if(id <= 0)
					throw(new NumberFormatException());
				Object user = UsersController.instance().getUserProfile(id);
				if(user == null)
					responseObject = new ErrorMessage("Error : there is no user N°"+id);
				else
		 			responseObject = user;
			}
			catch(NumberFormatException e){
				responseObject = new ErrorMessage("Error : the specified ID is not correct");
			}
		}
		else{
			List users = UsersController.instance().getUsersProfile();
			if(users.size() == 0)
				responseObject = new ErrorMessage("There is not user in the database");
			else
				responseObject = users;
		}
		
		Rest.AddObjectAsJSONResponse(responseObject,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
