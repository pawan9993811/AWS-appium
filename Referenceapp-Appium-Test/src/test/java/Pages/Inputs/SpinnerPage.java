/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Pages.Inputs;

import Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * A page for a spinner control
 */
public class SpinnerPage extends BasePage{
    /**
     * saves the last entry
     */
    private String selectedEntry;

    /**
     * The spinner control
     */
    @AndroidFindBy(id = "input_spinner")
    private MobileElement spinner;

    /**
     * The text display
     */
    @AndroidFindBy(id = "input_spinner_message")
    private MobileElement display;

    public SpinnerPage(AppiumDriver driver) {
        super(driver);
        selectedEntry = null;
    }

    /**
     * Selects a specific item from the spinner control
     *
     * @param index of the spinner items
     */
    public void selectSpinnerAtIndex(int index) {
        spinner.click();
        List<WebElement> entries = driver.findElementsByClassName("android.widget.TextView");
        selectedEntry = entries.get(index).getText();
        entries.get(index).click();
    }

    /**
     *
     * @return the selected entry
     */
    public String getSelectedEntry() {
        return selectedEntry;
    }

    /**
     *
     * @return the text from the display
     */
    public String getDisplayText() {
        return display.getText();
    }
}
