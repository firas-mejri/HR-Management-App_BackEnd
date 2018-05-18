package io.hrmanagementapp.hrspace.leaverequests;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends MongoRepository<LeaveRequest, String> {

}
