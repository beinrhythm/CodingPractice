package com.practice.controller.dao;

import java.util.Arrays;
import java.util.List;
import com.google.common.collect.Lists;

/**
 * Created by abhi.pandey on 9/21/14.
 */

public class StuffDao implements Dao<String> {
    static List<String> content = Lists.newArrayList();


    @Override
    public List<ResponseObject> get(String listId) {
        return null;
    }

    @Override
    public List<ResponseObject> get(String listId, int index) {
        return null;
    }

    @Override
	public String getById( String id ) {
		return content.get(1);
	}
    static{
        content = Arrays.asList( "Stuff", "Something else", "Whatever" );
    }
}
