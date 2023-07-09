package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

	private String id;
	private int level;
	
	// 트랜잭션 아이디와 깊이(레벨)
	
	public TraceId(String id, int level) {
		super();
		this.id = id;
		this.level = level;
	}
	
	public TraceId() {
		this.id = createId();
		this.level = 0;
	}
	
	private String createId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}
	
	public TraceId createNextId() {
		return new TraceId(id, level + 1);
	}

	public TraceId createPreviousId() {
		return new TraceId(id, level - 1);
	}

	public boolean isFirstLevel() {
		return level == 0;
	}

	public String getId() {
		return id;
	}

	public int getLevel() {
		return level;
	}
}
