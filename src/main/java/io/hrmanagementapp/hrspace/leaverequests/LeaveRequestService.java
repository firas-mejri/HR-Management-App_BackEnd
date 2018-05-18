package io.hrmanagementapp.hrspace.leaverequests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveRequestService {
	
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;
	@Autowired
	private NextSequenceService nextSequenceService;

	public List<LeaveRequest> getAllRequests() {
		
		return leaveRequestRepository.findAll();
	}

	public LeaveRequest getRequestById(String reqId) {
		
		return leaveRequestRepository.findById(reqId).get();
	}

	public String respondToRequest(String reqId, LeaveRequest leaveRequest) {
		
		leaveRequest.setRequestId(reqId);
		if(leaveRequestRepository.existsById(reqId)) {
			leaveRequestRepository.save(leaveRequest);
			return "Demande de congé Traité";
		}else {
			return "Demande de congé inexistante";
		}
	}

	// Add Method only for testing then it has to be deleted
	public String addLeaveRequest(LeaveRequest leaveRequest) {
		
		leaveRequest.setRequestId(String.valueOf(nextSequenceService.getNextSequence("customSequences")));
		leaveRequestRepository.save(leaveRequest);
		return "Saved";
		
	}

}
