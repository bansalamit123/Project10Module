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
import com.rays.dto.PositionDTO;
import com.rays.form.PositionForm;
import com.rays.service.PositionServiceInt;

@RestController
@RequestMapping(value = "Position")
public class PositionCtl extends BaseCtl<PositionForm, PositionDTO, PositionServiceInt> {


	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "Open");
		map.put(2, "Close");
		map.put(3, "OnHold");
		res.addResult("conditionList", map);
		return res;
	}
	
}
