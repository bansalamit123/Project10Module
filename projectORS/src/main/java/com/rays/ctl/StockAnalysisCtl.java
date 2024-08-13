
package com.rays.ctl;

import java.util.List;

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
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.StatusDTO;
import com.rays.dto.AnalysisTypeDTO;
import com.rays.dto.StockAnalysisDTO;
import com.rays.form.StockAnalysisForm;
import com.rays.service.StatusServiceInt;
import com.rays.service.AnalysisTypeServiceInt;
import com.rays.service.StockAnalysisServiceInt;

@RestController
@RequestMapping(value = "StockAnalysis")
public class StockAnalysisCtl extends BaseCtl<StockAnalysisForm, StockAnalysisDTO, StockAnalysisServiceInt> {

	@Autowired
	AnalysisTypeServiceInt AnalysisTypeService;

	@Autowired
	StockAnalysisServiceInt StockAnalysisService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload Amit");
		ORSResponse res = new ORSResponse(true);
		AnalysisTypeDTO dto = new AnalysisTypeDTO();
		List<DropdownList> list = AnalysisTypeService.search(dto, userContext);
		res.addResult("analysisTypeList", list);
		return res;
	}

	@PostMapping
	public ResponseEntity<String> createStockAnalysis(@Valid @RequestBody StockAnalysisForm StockAnalysisForm) {
		// Handle the logic to save the patient
		return new ResponseEntity<>("StockAnalysis created successfully", HttpStatus.CREATED);
	}
}
