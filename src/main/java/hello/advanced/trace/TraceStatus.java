package hello.advanced.trace;

public class TraceStatus {

	private TraceId traceId;
	
	private Long startTimeMs; // 로그시작시간
	
	private String message;

	public TraceId getTraceId() {
		return traceId;
	}

	public Long getStartTimeMs() {
		return startTimeMs;
	}

	public String getMessage() {
		return message;
	}

	public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
		this.traceId = traceId;
		this.startTimeMs = startTimeMs;
		this.message = message;
	}
}
