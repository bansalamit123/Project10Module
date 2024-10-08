package com.rays.ctl;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AssetDTO;
import com.rays.form.AssetForm;
import com.rays.service.AssetServiceInt;

@RestController
@RequestMapping(value = "Asset")
public class AssetCtl extends BaseCtl<AssetForm, AssetDTO, AssetServiceInt> {


	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload Paras");
		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "Red");
		map.put(2, "Black");
		res.addResult("paintColorList", map);
		return res;
	}
	
}
