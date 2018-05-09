package io.hrmanagementapp.hrspace.fichedepaiegeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FichedePaieController {
	
	@Autowired
	private FichedePaieService fichedePaieService;
	
	@RequestMapping("/employee/fichedepaie/{id}")
	public FichedePaie getFichedePaieById(@PathVariable String id) {
		return fichedePaieService.getFichedePaieById(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employee/fichedepaie/{id}")
	public String addFichedePaie(@PathVariable String id,@RequestBody FichedePaie fichedePaie) {
		
		return fichedePaieService.addFichedePaie(id, fichedePaie);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employee/fichedepaie/{id}")
	public String updateFichedePaie(@PathVariable String id, @RequestBody FichedePaie fichedePaie) {
		return fichedePaieService.updateFichedePaie(id, fichedePaie);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employee/fichedepaie/{id}")
	public String deleteFichedePaie(@PathVariable String id) {
		return fichedePaieService.deleteFichedePaie(id);
	}

}
