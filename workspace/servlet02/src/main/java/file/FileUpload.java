package file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig //파일업로드를 위한 annotation
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		//이름불러오고
		
		
		//업로드하려는 파일을 저장할 물리적 위치 지정 webapp/upload폴더에 저장할꺼임.
		String path = getServletContext().getRealPath("upload");
		//이 path는 D:\Study_Web\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0
		//(만약, 여러개인경우 마지막 폴더)
		// wtpwebapps 폴더 현재 프로젝트 
		//여기까지가 realpath
		// D:\Study_Web\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\servlet02
		// 여기 뒤에 upload가 붙어있음.
		
		//해당 지정 폴더가 없으면 폴더생성
		File dir = new File(path);
		if( ! dir.exists() )
			dir.mkdirs();
		

		//업로드한 파일 목록을 저장핼 배열선언
		ArrayList<String> list = new ArrayList<String>();
		

		//파일정보 확인 파일정보는 getParts로 얻어올 수 있음.
		Collection<Part> files =  request.getParts();
		
		for (Part file : files) {
			//첨부파일 태그는 name attach1, attach2
			if(file.getName().contains("attach") && ! file.getSubmittedFileName().isEmpty() ) {
				//파일에 attach라고 들어있고
				//첨부되었는지도 확인(파일네임이 엠티가 아닌!)
				String filename = file.getSubmittedFileName();
				//파일이름 뭔지 알아내서
				file.write(path + "/" + filename);
				//파일을 경로에 저장 ->위로가서 배열선언
				
				//업로드한 파일 목록을 저장핼 배열선언
				list.add(filename);
			}
		}
		
		//응답화면 연결
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href='./'>홈으로</a></div>");
		out.print("<div><a href='file.html'>파일업로드</a></div>");
		out.print("<hr>");
		
		out.print("<h2>업로드된 정보</h2>");
		
		
		out.printf("이름 : %s" ,name);
		for (String filename  : list) {
			out.printf("<div>파일명 : <a href='download?filename=%s'>%s</a></div>",filename,filename);
			
		}

		out.print("</body>");
		out.print("</html>");
		
	}

}
