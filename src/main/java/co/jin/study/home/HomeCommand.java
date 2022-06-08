package co.jin.study.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jin.study.comm.Command;

public class HomeCommand implements Command{

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "home/home";
	}
	

}
