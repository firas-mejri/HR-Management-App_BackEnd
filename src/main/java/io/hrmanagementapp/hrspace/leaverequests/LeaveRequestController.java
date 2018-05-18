package io.hrmanagementapp.hrspace.leaverequests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveRequestController {
	
	@Autowired
	private LeaveRequestService leaveRequestService;
	
	@RequestMapping("/leavedaysrequests")
	public List<LeaveRequest> getAllRequests(){
		
		return leaveRequestService.getAllRequests();
	}
	
	@RequestMapping("/leavedaysrequest/{reqId}")
	public LeaveRequest getRequestById(@PathVariable String reqId) {
		return leaveRequestService.getRequestById(reqId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/leavedaysrequest/{reqId}")
	public String resopondToRequest(@PathVariable String reqId,@RequestBody LeaveRequest leaveRequest) {
		return leaveRequestService.respondToRequest(reqId, leaveRequest);
	}
	
	// Add Method only for testing then it has to be deleted
	@RequestMapping(method=RequestMethod.POST, value="/leavedaysrequest")
	public String AddLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
		
		return leaveRequestService.addLeaveRequest(leaveRequest);
	}
	
	

}
