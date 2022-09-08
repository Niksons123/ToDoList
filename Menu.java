import entity.Task;
import entity.User;
import service.AuthorizationService;
import service.TaskService;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner( System.in );

    private final AuthorizationService authorizationService = new AuthorizationService();
    private final TaskService taskService = new TaskService();

    private User activeUser;

    public void start() {
        while (activeUser == null) {
            login();
        }
        workWithTasks();
    }

    private void login() {
        System.out.println( "1. Авторизация\n2. Регистрация\n3. Выход" );
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                activeUser = authorizationService.authorization( scanner );
                break;
            case 2:
                authorizationService.registration( scanner );
                break;
            case 3:
                System.exit( 0 );
        }
    }

    private void workWithTasks() {
        while (true) {
            System.out.println( "1.Добавить заметку\n2. Найти заметку\n3. Изменить заметку\n4. Удалить заметку.\n5. Выход" );
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println( "Введите название" );
                    String name = scanner.next();
                    System.out.println( "Введите описание" );
                    String description = scanner.next();
                    System.out.println( "Введите статус" );
                    String status = scanner.next();
                    System.out.println( "Введите категорию" );
                    String category = scanner.next();
                    Task createdTask = taskService.saveTask( name, description, status, category );
                    System.out.format( "Создана заметка с ID=%s", createdTask.getId());
                    System.out.println();
                    break;
                case 2:
                    System.out.println( "Введите id заметки" );
                    int id = scanner.nextInt();
                    Task task = taskService.findTask( id );
                    System.out.println( task );
                    break;
                case 3:
                    System.out.println( "Введите id заметки" );
                    id = scanner.nextInt();
                    task = taskService.findTask( id );
                    System.out.println( "Введите название" );
                    name = scanner.next();
                    System.out.println( "Введите описание" );
                    description = scanner.next();
                    System.out.println( "Введите статус" );
                    status = scanner.next();
                    System.out.println( "Введите категорию" );
                    category = scanner.next();
                    taskService.updateTask( id, name, description, status, category );
                    System.out.println( task );
                    break;
                case 4:
                    System.out.println( "Введите id заметки" );
                    id = scanner.nextInt();
                    Task removedTask = taskService.deleteTask( id );
                    System.out.format( "Удалена заметка с ID=%s", removedTask.getId());
                    System.out.println();
                    break;
                case 5:
                   System.exit( 0 );
            }
        }
    }


}
