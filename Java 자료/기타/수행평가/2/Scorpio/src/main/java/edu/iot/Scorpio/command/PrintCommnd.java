package edu.iot.Scorpio.command;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import edu.iot.Scorpio.model.TourItem;
import edu.iot.Scorpio.model.TourPlan;
import edu.iot.Scorpio.model.TourSpot;
import edu.iot.Scorpio.service.TourPlanService;
import edu.iot.Scorpio.service.TourPlanServiceImpl;
import edu.iot.common.command.Command;

public class PrintCommnd implements Command {
	TourPlanService service = TourPlanServiceImpl.getInstance();
	@Override
	public void execute() throws Exception {
		TourPlan plan = service.getPlan();
		
		String path = "c:/temp/tour.html";
		try (
				PrintWriter pw = new PrintWriter(new FileWriter(path));
			
		){
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<meta charset=\"utf-8\">\n");
				pw.printf("<title>%s</title>\n",plan.getTitle());
				pw.println("</head>");
				pw.println("<body>");
				pw.printf("<h3>%s</h3>\n",plan.getTitle());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				pw.println();
				pw.println("<p>=================================================</p>");
				pw.println("<p>제목 : "+plan.getTitle()+"</p>");
				pw.printf("<p>기간 : %s~%s\n</p>",
										sdf.format(plan.getBegin()),
										sdf.format(plan.getEnd()));
				pw.printf("<p>내용 : </p>\n<p>%s</p>\n",plan.getDescription());
				pw.println("<p>=================================================</p>");
				
				//		세부 일정
				List<TourItem> tourList = plan.getTourList();
				pw.printf("<p>세부일정(%d건)\n</p>",tourList.size());
				pw.println("<table>");
				for(int i=0; i<tourList.size();i++) {
					TourItem item = tourList.get(i);
					System.out.printf("<tr><td>%d]</td><td> %s</td> <td>%s</td>\n</tr>",
							i, sdf.format(item.getDate()),
							item.getSpot());
				}
				System.out.println("</table>");
				
				//	TourSpot 출력
				for(int i = 0; i<tourList.size();i++) {
					TourSpot spot = tourList.get(i).getSpot();
					pw.printf("<p>%d. %s</p>", i, spot.getName());
					pw.printf("<p>%s</p>", spot.getRegion());
					pw.printf("<p>%s</p>", spot.getLocation());
					pw.printf("<p>%s</p>", spot.getContent());
					pw.printf("<p>%s</p>", spot.getAddress());
					pw.printf("<p><a href=\"%s\">%s</p></a>",
							spot.getHomePage(),spot.getHomePage());
					pw.println("<hr>");
				}
				
				
				
				
				pw.println("</body>");
				pw.println("</html>");
				
				
				
				
				
				new ProcessBuilder("cmd","/c","start",path).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}