package jp.cloudace.tech.clean.demo.tasks.application.usecases.ports;

public interface CreateTaskUseCaseInputPort {
    void execute(String name, String description);
}
