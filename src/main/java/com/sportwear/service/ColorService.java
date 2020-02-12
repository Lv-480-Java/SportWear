package com.sportwear.service;

import com.sportwear.dao.ColorDao;
import com.sportwear.entity.Color;
import org.apache.log4j.Logger;

import java.util.List;

public class ColorService {
    private static Logger logger = Logger.getLogger(ColorService.class.getName());
    private ColorDao colorDao = new ColorDao();

    public void add(Color color) {
        colorDao.create(color);
    }

    public List<Color> getAllColor() {
        return colorDao.readAll();
    }

    public Color getOneColor(Long id) {
        return colorDao.readById(id);
    }

    public void update(Color color, Long id) {
        colorDao.update(color, id);
    }

    public void remove(Long id) {
        colorDao.delete(id);
    }
}
