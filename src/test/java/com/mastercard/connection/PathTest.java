package com.mastercard.connection;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class PathTest extends PathAbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void checkPathBstn2Nwrk() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Boston").param("destination", "Newark"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("yes", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void checkPathPhil2Abny() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Albany"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("no", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void checkPathBstn2Phil() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Boston").param("destination", "Philadelphia"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("yes", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void checkPathPhil2Phil() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Philadelphia"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("no", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void badReq400() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("orgin", "Trenton").param("destination", "Boston"))
				.andReturn();

		assertEquals(400, mvcResult.getResponse().getStatus());
	}

	@Test
	public void fail() throws Exception {
		String uri = "/connectd";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Philadelphia").param("destination", "Albany"))
				.andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
	}

	@Test
	public void checkPathTrtn2Bstn() throws Exception {
		String uri = "/connected";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("origin", "Trenton").param("destination", "Boston"))
				.andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("no", mvcResult.getResponse().getContentAsString());
	}

}