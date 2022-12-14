package ru.yandex.practicum.filmorate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.yandex.practicum.filmorate.model.enums.FriendStatus;

@Data
@AllArgsConstructor
public class Friendship {
    private long userId;
    private long friendId;
    private FriendStatus friendStatus;
}
