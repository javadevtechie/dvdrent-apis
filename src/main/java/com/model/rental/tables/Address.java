/*
 * This file is generated by jOOQ.
 */
package com.model.rental.tables;


import com.model.rental.DefaultSchema;
import com.model.rental.Indexes;
import com.model.rental.Keys;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

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
public class Address extends TableImpl<Record> {

    private static final long serialVersionUID = -1974708457;

    /**
     * The reference instance of <code>address</code>
     */
    public static final Address ADDRESS = new Address();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>address.address_id</code>.
     */
    public final TableField<Record, Integer> ADDRESS_ID = createField(DSL.name("address_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('dvdrental.address_address_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>address.address</code>.
     */
    public final TableField<Record, String> ADDRESS_ = createField(DSL.name("address"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>address.address2</code>.
     */
    public final TableField<Record, String> ADDRESS2 = createField(DSL.name("address2"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>address.district</code>.
     */
    public final TableField<Record, String> DISTRICT = createField(DSL.name("district"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>address.city_id</code>.
     */
    public final TableField<Record, Integer> CITY_ID = createField(DSL.name("city_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>address.postal_code</code>.
     */
    public final TableField<Record, String> POSTAL_CODE = createField(DSL.name("postal_code"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>address.phone</code>.
     */
    public final TableField<Record, String> PHONE = createField(DSL.name("phone"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>address.last_update</code>.
     */
    public final TableField<Record, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * Create a <code>address</code> table reference
     */
    public Address() {
        this(DSL.name("address"), null);
    }

    /**
     * Create an aliased <code>address</code> table reference
     */
    public Address(String alias) {
        this(DSL.name(alias), ADDRESS);
    }

    /**
     * Create an aliased <code>address</code> table reference
     */
    public Address(Name alias) {
        this(alias, ADDRESS);
    }

    private Address(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Address(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Address(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, ADDRESS);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ADDRESS_PKEY, Indexes.IDX_FK_CITY_ID);
    }

    @Override
    public Identity<Record, Integer> getIdentity() {
        return Keys.IDENTITY_ADDRESS;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.ADDRESS_PKEY;
    }

    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.ADDRESS_PKEY);
    }

    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.ADDRESS__FK_ADDRESS_CITY);
    }

    public City city() {
        return new City(this, Keys.ADDRESS__FK_ADDRESS_CITY);
    }

    @Override
    public Address as(String alias) {
        return new Address(DSL.name(alias), this);
    }

    @Override
    public Address as(Name alias) {
        return new Address(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Address rename(String name) {
        return new Address(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Address rename(Name name) {
        return new Address(name, null);
    }
}
