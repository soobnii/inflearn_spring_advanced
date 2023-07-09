package hello.advanced.app.v5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;

@RestController
public class OrderControllerV5 {

	private final OrderServiceV5 orderService;
	private final TraceTemplate template;
	
	@Autowired // 생성자 한개라 생략 가능
	public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
		this.orderService = orderService;
		this.template = new TraceTemplate(trace); // 의존관계 주입
	}
	
	@GetMapping("/v5/request")
	public String request(String itemId) {
		
		return template.execute("OrderController.request()", new TraceCallback<>() {
					@Override
					public String call() {
						orderService.orderItem(itemId);
						return "ok";
					}
				});
	}
}
