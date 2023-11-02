package com.minatoorgtestcase.prodtest1.model;

import com.minatoorgtestcase.prodtest1.base.model.ApplicationUserBase;
import com.eva.base.annotations.Table;

@Table(name="ApplicationUser", keys={"sid"})
public class ApplicationUser extends ApplicationUserBase {

}