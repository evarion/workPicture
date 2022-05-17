package com.evarion.workPicture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChangeColor {

    public static void main(String[] args) {
        changeColor();
    }
        static void changeColor() {
            try {
                // Открываем изображение
                File file = new File("D:\\test\\1.jpg");
                BufferedImage source = ImageIO.read(file);

                // Создаем новое пустое изображение, такого же размера
                BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());

                // Делаем двойной цикл, чтобы обработать каждый пиксель
                for (int x = 0; x < source.getWidth(); x++) {
                    for (int y = 0; y < source.getHeight(); y++) {

                        // Получаем цвет текущего пикселя
                        Color color = new Color(source.getRGB(x, y));

                        // Получаем каналы этого цвета
                        int blue = color.getBlue();
                        int red = color.getRed();
                        int green = color.getGreen();

                        // Применяем стандартный алгоритм для получения черно-белого изображения
                        //int grey = (int) (red * 0.299 + green * 0.587 + blue * 0.114);
                        int grey = (int) (red * 0.299 + green * 0.587 + blue * 0.114);

                        // Если вы понаблюдаете, то заметите что у любого оттенка серого цвета, все каналы имеют
                        // одно и то же значение. Так, как у нас изображение тоже будет состоять из оттенков серого
                        // то, все канали будут иметь одно и то же значение.
                        int newRed = grey;
                        int newGreen = grey;
                        int newBlue = grey;

                        //  Cоздаем новый цвет
                        Color newColor = new Color(newRed, newGreen, newBlue);

                        // И устанавливаем этот цвет в текущий пиксель результирующего изображения
                        result.setRGB(x, y, newColor.getRGB());
                    }
                }

                // Созраняем результат в новый файл
                File output = new File("D:\\test\\2.jpg");
                ImageIO.write(result, "jpg", output);

            } catch (IOException e) {
                // При открытии и сохранении файлов, может произойти неожиданный случай.
                // И на этот случай у нас try catch
                System.out.println("Файл не найден или не удалось сохранить");
            }
        }
    }