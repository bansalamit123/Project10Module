package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.AnalysisTypeDTO;
import com.rays.form.AnalysisTypeForm;
import com.rays.service.AnalysisTypeServiceInt;

@RestController
@RequestMapping(value = "AnalysisType")
public class AnalysisTypeCtl extends BaseCtl<AnalysisTypeForm, AnalysisTypeDTO, AnalysisTypeServiceInt> {

	@Autowired
	private AnalysisTypeServiceInt AnalysisTypeService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		AnalysisTypeDTO dto = new AnalysisTypeDTO();
		List<DropdownList> list = AnalysisTypeService.search(dto, userContext);
		res.addResult("AnalysisTypeList", list);
		return res;
	}

	@GetMapping("name/{name}")
	public ORSResponse get(@PathVariable String name) {
		ORSResponse res = new ORSResponse(true);
		AnalysisTypeDTO dto = baseService.findByName(name, userContext);
		System.out.println("Product " + dto);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}

}
