package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> { 
	// 추상템플릿 생성 시 반환타입 지정 -> 타입에 대한 정보를 객체 생성 시점으로 미룸
	
	private final LogTrace trace;
	// final : 변하지 않음

	public AbstractTemplate(LogTrace trace) {
		this.trace = trace;
	}
	
	public T execute(String message) {
		TraceStatus status = null;
		try {
			status = trace.begin(message);
			
			T result = call();
			
			trace.end(status);
			return result;
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
	
	protected abstract T call();
}
