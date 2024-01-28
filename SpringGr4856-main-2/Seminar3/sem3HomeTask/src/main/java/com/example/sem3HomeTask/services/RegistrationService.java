package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * поле сервсиа работы с хранилищем пользователей
     */
    @Autowired
    private DataProcessingService dataProcessingService;

    /**
     * поле сервиса создания пользователей
     */
    @Autowired
    private final UserService userService;

    /**
     * поле сервиса консольных уведомлений
     */
    @Autowired
    private final NotificationService notificationService;

    //Поля UserService, NotificationService +

    /**
     * конструктор класса
     * @param dataProcessingService хранилище пользователей
     * @param userService создание пользователей
     * @param notificationService консольные уведомления
     */

    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notificationService){
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;

    }

    /**
     * сохранение пользователя в БД
     * @param name имя пользователя
     * @param age возраст пользователя
     * @param email емэйл пользователя
     */
    public void processRegistration (String name, int age, String email){
        User createUser = userService.createUser(name,age,email);
        dataProcessingService.addUserToList(createUser);
        notificationService.sendNotification("Пользователь сохранен! ");
    }


}
