/*
 * Copyright 2010 TimeSheet authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.iqapps.IQTimeSheet.Test;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googlecode.autoandroid.positron.PositronAPI;
import com.googlecode.autoandroid.positron.junit4.TestCase;

/**
 * Test to invoke the application once so that there is a database and
 * preferences file we can backup later.
 * 
 * @author kronenpj
 */
public class AAA_CreateDBPrefs extends TestCase {
	private Log log = LogFactory.getLog(AAA_CreateDBPrefs.class);
	private static final String TAG = "AAA_CreateDBPrefs";

	@Before
	public void setUp() {
		startActivity("com.googlecode.iqapps.IQTimeSheet",
				"com.googlecode.iqapps.IQTimeSheet.TimeSheetActivity");
	}

	@After
	public void tearDown() {
		finishAll();
	}

	@Test
	public void empty() {
		assurePreferencesAreCreated();
	}

	private void assurePreferencesAreCreated() {
		press(PositronAPI.Key.MENU);
		long waitTime = 80;
		Helpers.sleep(waitTime);
		press(PositronAPI.Key.RIGHT, PositronAPI.Key.RIGHT);
		Helpers.sleep(waitTime);
		press(PositronAPI.Key.ENTER);
		assertTrue(waitFor("class.simpleName", "MyPreferenceActivity", 500));
		press(PositronAPI.Key.BACK);
	}
}