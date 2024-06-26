package com.escodro.domain.usecase.alarm

/**
 * Use case to cancel an alarm.
 */
internal interface CancelAlarm {
    /**
     * Cancels an alarm.
     *
     * @param taskId the task id
     */
    suspend operator fun invoke(taskId: Long)
}
