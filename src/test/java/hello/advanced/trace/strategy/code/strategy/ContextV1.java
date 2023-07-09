package hello.advanced.trace.strategy.code.strategy;

import hello.advanced.trace.strategy.code.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {
	/**
	* 필드에 전략을 보관하는 방식
	*/
	private Strategy strategy;

	public ContextV1(Strategy strategy) {
		this.strategy = strategy;
	}

	public void execute() {
		long startTime = System.currentTimeMillis();
		//비즈니스 로직 실행
		strategy.call(); //위임
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}

}
