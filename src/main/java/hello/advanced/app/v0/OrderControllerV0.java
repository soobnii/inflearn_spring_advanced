package hello.advanced.app.v0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {

	// @Controller + @ResponseBody : 컴포넌트 스캔과 스프링 Rest 컨트롤러로 인식된다.
	private final OrderServiceV0 orderService;

	@GetMapping("/v0/request")
	public String request(String itemId) {
		orderService.orderItem(itemId);
		return "ok";
	}
}
