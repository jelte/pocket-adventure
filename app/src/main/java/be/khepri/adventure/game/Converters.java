package be.khepri.adventure.game;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Converters {
    @TypeConverter
    public static UUID uuidFromString(String value) {
        return value == null ? null : UUID.fromString(value);
    }

    @TypeConverter
    public static String uuidToString(UUID uuid) {
        return uuid == null ? null : uuid.toString();
    }

    @TypeConverter
    public static Vector2D vector2DFromString(String value) {
        return new Gson().fromJson(value, new TypeToken<Vector2D>() {}.getType());
    }

    @TypeConverter
    public static String vector2DToString(Vector2D behaviour) {
        return new Gson().toJson(behaviour);
    }
}
