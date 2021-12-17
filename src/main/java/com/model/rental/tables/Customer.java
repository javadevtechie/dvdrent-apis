/*
 * This file is generated by jOOQ.
 */
package com.model.rental.tables;


import com.model.rental.DefaultSchema;
import com.model.rental.Indexes;
import com.model.rental.Keys;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Customer extends TableImpl<Record> {

    private static final long serialVersionUID = 1291340183;

    /**
     * The reference instance of <code>customer</code>
     */
    public static final Customer CUSTOMER = new Customer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>customer.customer_id</code>.
     */
    public final TableField<Record, Integer> CUSTOMER_ID = createField(DSL.name("customer_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('dvdrental.customer_customer_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>customer.store_id</code>.
     */
    public final TableField<Record, Short> STORE_ID = createField(DSL.name("store_id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>customer.first_name</code>.
     */
    public final TableField<Record, String> FIRST_NAME = createField(DSL.name("first_name"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>customer.last_name</code>.
     */
    public final TableField<Record, String> LAST_NAME = createField(DSL.name("last_name"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>customer.email</code>.
     */
    public final TableField<Record, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>customer.address_id</code>.
     */
    public final TableField<Record, Short> ADDRESS_ID = createField(DSL.name("address_id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>customer.activebool</code>.
     */
    public final TableField<Record, Boolean> ACTIVEBOOL = createField(DSL.name("activebool"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("true", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>customer.create_date</code>.
     */
    public final TableField<Record, LocalDate> CREATE_DATE = createField(DSL.name("create_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false).defaultValue(org.jooq.impl.DSL.field("('now'::text)::date", org.jooq.impl.SQLDataType.LOCALDATE)), this, "");

    /**
     * The column <code>customer.last_update</code>.
     */
    public final TableField<Record, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), org.jooq.impl.SQLDataType.LOCALDATETIME.defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>customer.active</code>.
     */
    public final TableField<Record, Integer> ACTIVE = createField(DSL.name("active"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>customer</code> table reference
     */
    public Customer() {
        this(DSL.name("customer"), null);
    }

    /**
     * Create an aliased <code>customer</code> table reference
     */
    public Customer(String alias) {
        this(DSL.name(alias), CUSTOMER);
    }

    /**
     * Create an aliased <code>customer</code> table reference
     */
    public Customer(Name alias) {
        this(alias, CUSTOMER);
    }

    private Customer(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Customer(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Customer(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, CUSTOMER);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CUSTOMER_PKEY, Indexes.IDX_FK_ADDRESS_ID, Indexes.IDX_FK_STORE_ID, Indexes.IDX_LAST_NAME);
    }

    @Override
    public Identity<Record, Integer> getIdentity() {
        return Keys.IDENTITY_CUSTOMER;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.CUSTOMER_PKEY;
    }

    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.CUSTOMER_PKEY);
    }

    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.CUSTOMER__CUSTOMER_ADDRESS_ID_FKEY);
    }

    public Address address() {
        return new Address(this, Keys.CUSTOMER__CUSTOMER_ADDRESS_ID_FKEY);
    }

    @Override
    public Customer as(String alias) {
        return new Customer(DSL.name(alias), this);
    }

    @Override
    public Customer as(Name alias) {
        return new Customer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Customer rename(String name) {
        return new Customer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Customer rename(Name name) {
        return new Customer(name, null);
    }
}
