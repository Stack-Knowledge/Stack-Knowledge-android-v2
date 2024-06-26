package enumdata

enum class MissionStatus {
    CLOSED, // Mission을 풀 수 없는 상태
    OPENED, // Mission을 풀 수 있는 상태
    AVAILABLE_OPEN, // Mission을 내일 풀 수 있는 상태
}