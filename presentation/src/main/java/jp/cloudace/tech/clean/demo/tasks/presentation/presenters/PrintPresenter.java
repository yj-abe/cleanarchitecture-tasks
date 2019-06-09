package jp.cloudace.tech.clean.demo.tasks.presentation.presenters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.CompleteTaskUseCaseOutputPort;
import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.CreateTaskUseCaseOutputPort;
import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.ListCompletedTaskUseCaseOutputPort;
import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.ListTasksUseCaseOutputPort;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.Task;
import jp.cloudace.tech.clean.demo.tasks.presentation.presenters.viewmodels.Color;
import jp.cloudace.tech.clean.demo.tasks.presentation.presenters.viewmodels.PrintViewModel;
import jp.cloudace.tech.clean.demo.tasks.presentation.presenters.views.PrintView;

public class PrintPresenter implements CreateTaskUseCaseOutputPort, CompleteTaskUseCaseOutputPort,
        ListTasksUseCaseOutputPort, ListCompletedTaskUseCaseOutputPort {

    private final PrintView view;

    public PrintPresenter(PrintView view) {
        this.view = view;
    }

    @Override
    public void emitTask(Task task) {
        List<String> messages = new ArrayList<>();
        messages.add("Following task was created!!");
        messages.add(task.toString());

        PrintViewModel viewModel = new PrintViewModel(messages, Color.GREEN);
        view.print(viewModel);
    }

    @Override
    public void emitCompletedTaskId(String completedTaskId) {
        List<String> messages = new ArrayList<>();
        messages.add("WELL DONE. task id: " + completedTaskId + " changed to complete. :D");

        PrintViewModel viewModel = new PrintViewModel(messages, Color.GREEN);
        view.print(viewModel);
    }

    @Override
    public void emitTasks(List<Task> tasks) {
        printTasks(tasks);
    }

    @Override
    public void emitCompletedTasks(List<CompletedTask> tasks) {
        printTasks(tasks);
    }


    @Override
    public void showErrors(String[] errors) {
        List<String> messages = Arrays.stream(errors)
                .map(error -> "Error : " + error)
                .collect(Collectors.toList());
        PrintViewModel viewModel = new PrintViewModel(messages, Color.RED);
        view.print(viewModel);
    }

    private void printTasks(List<? extends Task> tasks) {
        List<String> messages = tasks.isEmpty()
                ? Collections.singletonList("no tasks")
                : tasks.stream().map(Task::toString).collect(Collectors.toList());
        PrintViewModel viewModel = new PrintViewModel(messages, Color.GREEN);
        view.print(viewModel);
    }

}
