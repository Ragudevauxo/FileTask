package controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mod.Modeler;

@Controller
public class FileUploadController {
  public static String uploadDirectory = System.getProperty("user.dir")+"\\uploads";
  public static String name="";
  @RequestMapping("/")

  public String UploadPage(Model model) {
	  return "uploadview";
  }
  @PostMapping("/upload")
  public String upload(Model model,@RequestParam("files") MultipartFile[] files) throws Exception {

	  //String name="";
	  StringBuilder fileNames = new StringBuilder();
	  for (MultipartFile file : files) {
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename()+" ");
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		  if(!file.isEmpty())
		  {
			  name=uploadDirectory+"\\"+file.getOriginalFilename();
		  }
		  System.out.println(name);
	  }
	  System.out.println("outside"+name);
	//  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
//	  ToJson obj=new ToJson();
//		 // System.out.println(name);
//		  String res[]=obj.toJson(name);
//		  System.out.println(Arrays.deepToString(res));
	 
	  return "uploadstatusview";
}
  
  @RequestMapping( "/greeting")
  public @ResponseBody
  Modeler greeting() throws Exception {
	  ToJson obj=new ToJson();
		 // System.out.println(name);
		  String res[]=obj.toJson(name);
		  System.out.println(Arrays.deepToString(res));
	 
	  return new Modeler(res[0],res[1],res[2],res[3],res[4],res[5]);
  }
  }
  
  

