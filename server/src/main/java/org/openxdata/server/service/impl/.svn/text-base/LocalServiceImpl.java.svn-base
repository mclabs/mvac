/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server.service.impl;

import java.util.List;
import org.openxdata.server.admin.model.Locale;
import org.openxdata.server.dao.LocaleDAO;
import org.openxdata.server.service.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jonny Heggheim
 */
@Transactional
@Service("localeService")
public class LocalServiceImpl implements LocaleService {

    private LocaleDAO localeDAO;

    @Autowired
    public LocalServiceImpl(LocaleDAO localeDAO) {
        this.localeDAO = localeDAO;
    }

    @Override
	public void deleteLocale(Locale locale) {
        localeDAO.deleteLocale(locale);
    }

    @Override
	@Transactional(readOnly = true)
    public List<Locale> getLocales() {
        return localeDAO.getLocales();
    }

    @Override
	public void saveLocale(List<Locale> locales) {
        localeDAO.saveLocale(locales);
    }
}
