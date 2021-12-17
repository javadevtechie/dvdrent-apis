/*
 * This file is generated by jOOQ.
 */
package com.model.rental.tables;


import com.model.rental.DefaultSchema;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerList extends TableImpl<Record> {

    private static final long serialVersionUID = -156336130;

    /**
     * The reference instance of <code>customer_list</code>
     */
    public static final CustomerList CUSTOMER_LIST = new CustomerList();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>customer_list.id</code>.
     */
    public final TableField<Record, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>customer_list.name</code>.
     */
    public final TableField<Record, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>customer_list.address</code>.
     */
    public final TableField<Record, String> ADDRESS = createField(DSL.name("address"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>customer_list.zip code</code>.
     */
    public final TableField<Record, String> ZIP_CODE = createField(DSL.name("zip code"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>customer_list.phone</code>.
     */
    public final TableField<Record, String> PHONE = createField(DSL.name("phone"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>customer_list.city</code>.
     */
    public final TableField<Record, String> CITY = createField(DSL.name("city"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>customer_list.country</code>.
     */
    public final TableField<Record, String> COUNTRY = createField(DSL.name("country"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>customer_list.notes</code>.
     */
    public final TableField<Record, String> NOTES = createField(DSL.name("notes"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>customer_list.sid</code>.
     */
    public final TableField<Record, Short> SID = createField(DSL.name("sid"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * Create a <code>customer_list</code> table reference
     */
    public CustomerList() {
        this(DSL.name("customer_list"), null);
    }

    /**
     * Create an aliased <code>customer_list</code> table reference
     */
    public CustomerList(String alias) {
        this(DSL.name(alias), CUSTOMER_LIST);
    }

    /**
     * Create an aliased <code>customer_list</code> table reference
     */
    public CustomerList(Name alias) {
        this(alias, CUSTOMER_LIST);
    }

    private CustomerList(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private CustomerList(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> CustomerList(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, CUSTOMER_LIST);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public CustomerList as(String alias) {
        return new CustomerList(DSL.name(alias), this);
    }

    @Override
    public CustomerList as(Name alias) {
        return new CustomerList(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerList rename(String name) {
        return new CustomerList(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerList rename(Name name) {
        return new CustomerList(name, null);
    }
}
