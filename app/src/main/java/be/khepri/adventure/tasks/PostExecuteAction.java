package be.khepri.adventure.tasks;

public interface PostExecuteAction<T> {
     void onPostExecute(T returnValue);
}
