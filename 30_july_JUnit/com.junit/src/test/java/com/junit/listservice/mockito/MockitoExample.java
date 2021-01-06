package com.junit.listservice.mockito;

import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.*;

import org.junit.Test;

import com.junit.listservice.ListService;
import com.junit.listservice.application.ListApplication;

public class MockitoExample {
	
    ListApplication listApplication = new ListApplication();


    ListService listService = mock(ListService.class);
    
    
	@Test
	public void MockitoSingleTest()
	{
	   when(listService.checkEmail(anyString())).thenReturn(true);
	   assertEquals(true,listService.checkEmail("invalidEmailId"));	
	}
	
}
