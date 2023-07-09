
package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.Strategy;
import hello.advanced.trace.strategy.code.StrategyLogic1;
import hello.advanced.trace.strategy.code.StrategyLogic2;
import hello.advanced.trace.strategy.code.strategy.ContextV1;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1Test {
	
	@Test
	void strategyV0() {
		logic1();
		logic2();
	}
	
	private void logic1() {
		long startTime = System.currentTimeMillis();
		//비즈니스 로직 실행
		log.info("비즈니스 로직1 실행");
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}
	
	private void logic2() {

		long startTime = System.currentTimeMillis();
		//비즈니스 로직 실행
		log.info("비즈니스 로직2 실행");
		//비즈니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}", resultTime);
	}
	
	
	/**
	* 전략 패턴 적용
	*/
	@Test
	void strategyV1() {
		Strategy strategyLogic1 = new StrategyLogic1();
		ContextV1 context1 = new ContextV1(strategyLogic1);
		context1.execute();
	
		Strategy strategyLogic2 = new StrategyLogic2();
		ContextV1 context2 = new ContextV1(strategyLogic2);
		context2.execute();
	}
	
	/**
	* 전략 패턴 익명 내부 클래스1
	*/
	@Test
	void strategyV2() {
		Strategy strategyLogic1 = new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");
			}
		};
		log.info("strategyLogic1={}", strategyLogic1.getClass());
		ContextV1 context1 = new ContextV1(strategyLogic1);
		context1.execute();
	
		Strategy strategyLogic2 = new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");
			}
		};
		log.info("strategyLogic2={}", strategyLogic2.getClass());
		ContextV1 context2 = new ContextV1(strategyLogic2);
		context2.execute();
	}
	
	/**
	* 전략 패턴 익명 내부 클래스2
	*/
	@Test
	void strategyV3() {
		// 익명 내부 클래스를 변수에 담아두지 말고, 생성하면서 바로 ContextV1 에 전달해도 된다.
		ContextV1 context1 = new ContextV1(new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");
			}
		});
		context1.execute();
	
		ContextV1 context2 = new ContextV1(new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");
			}
		});
		context2.execute();
	}
	
	
	/**
	* 전략 패턴, 람다
	*/
	@Test
	void strategyV4() {
		ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
		context1.execute();
	
		ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
		context2.execute();
	}
}
