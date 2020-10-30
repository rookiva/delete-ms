package com.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.domain.User;

/* direct invocation*/
//@FeignClient(name = "read-ms", url = "http://localhost:9020")
//public interface ReaderProxy {
//
//	@GetMapping("/read")
//	public List<User> read();
//
//}

/* invoke via zuul */
@FeignClient(name = "zuul-ms")
public interface ReaderProxy {

	@GetMapping("read-ms/read")
	public List<User> read();

}