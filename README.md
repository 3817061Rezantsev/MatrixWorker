# MatrixWorker
Работа с матрицами (базовая стоимость 5 баллов)
Создать класс для работы с матрицами, реализующий следующий интерфейс
public interface IMatrixWorker {
   public void print(double[][] m);
   public boolean haveSameDimension(double[][] m1, double[][] m2);
   public double[][] add(double[][] m1, double[][] m2);
   public double[][] subtract(double[][] m1, double[][] m2);
   public double[][] multiply(double[][] m1, double[][] m2);
}
* Дополнительные задачи:
1) Реализовать класс описывающий матрицу как сущность (POJO) + 1 балл
2) Реализовать метод считающий определитель матрицы методом Крамера + 3 балла
