package com.cg.paymentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.BeneficiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.service.IBeneficiaryService;

@RestController
public class BeneficiaryController {
	
	@Autowired
	IBeneficiaryService beneService;

	@GetMapping("/viewbeneficiary")
	public BeneficiaryDetails viewBeneficiary(@RequestBody BeneficiaryDetails bd) {
		return beneService.viewBeneficiary(bd);
	}
	@PutMapping("/updatebenificiary")
	public BeneficiaryDetails updateBeneficiary(@RequestBody BeneficiaryDetails bd) {
		return beneService.updateBeneficiary(bd);
	}

	@PostMapping("/addbeneficiary")
	public BeneficiaryDetails addBeneficiary(@RequestBody BeneficiaryDetails bd) {
		return beneService.addBeneficiary(bd);
	}
	@DeleteMapping("/deletebeneficiary")
	public BeneficiaryDetails deleteBeneficiar(@RequestBody BeneficiaryDetails bd) {
		return beneService.deleteBeneficiary(bd);
	}
	
	@GetMapping("/viewallbeneficiary")
	public List<BeneficiaryDetails> viewAllBeneficiary(@RequestBody Customer c) {
		return beneService.viewAllBeneficiary(c);
	}

}
