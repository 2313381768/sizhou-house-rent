package com.young.sizhou.houserent.controller;


import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.service.HouseService;
import com.young.sizhou.houserent.utils.OssFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;


@Controller
public class AddHouseController {

	@Autowired
	private HouseService houseService;

	@RequestMapping("/MultipleUpload")
	@ResponseBody
	public Map<String, Object> upload(@RequestParam("file") List<MultipartFile> file, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String,Object>();
		if (!file.isEmpty() && file.size() > 0) {
			// 详细图片地址
			StringBuilder detailsPath = new StringBuilder();
			for (MultipartFile f : file) {
				try {
					// 文件名
					String filename = UUID.randomUUID()
							+ f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
					// 存储虚拟路径
					String url = OssFileUtils.uploadFile(filename, f);
					detailsPath.append(url+"~");
				} catch (Exception e) {
					map.put("code", 1);
					map.put("msg", "上传失败");
					e.printStackTrace();
				}
			}
			map.put("imgs",detailsPath.toString());
			map.put("code", 0);
			map.put("msg", "上传成功");
		}
		return map;
	}

	@RequestMapping("/singleUpload")
	@ResponseBody
	public Map<String, Object> singleUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String filename = UUID.randomUUID() + suffixName;
			//创建虚拟路径存储
			String simplePath = OssFileUtils.uploadFile(filename,file);//simplePath是个全局变量
			map.put("image", simplePath);
			map.put("code", 0);
			map.put("msg", "上传成功");
		} catch (Exception e) {
			map.put("code", 1);
			map.put("msg", "上传失败");
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/addHouse")
	public String addHouse() {
		return "addhouse";
	}
	
	@RequestMapping("/addHouseRecord")
	@ResponseBody
	public String addHouse(HouseEntity house) {
		if(house.getPublisher()==null||"".equals(house.getPublisher())) {
			house.setPublisher("管理员");
		}
		house.setPublishTime(new Date());
		boolean save = houseService.save(house);
		if(save) {
			return "OK";
		}
		return "FAIL";
	}
}
