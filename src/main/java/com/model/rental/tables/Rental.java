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
public class Rental extends TableImpl<Record> {

    private static final long serialVersionUID = -995345734;

    /**
     * The reference instance of <code>rental</code>
     */
    public static final Rental RENTAL = new Rental();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>rental.rental_id</code>.
     */
    public final TableField<Record, Integer> RENTAL_ID = createField(DSL.name("rental_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('dvdrental.rental_rental_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>rental.rental_date</code>.
     */
    public final TableField<Record, LocalDateTime> RENTAL_DATE = createField(DSL.name("rental_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>rental.inventory_id</code>.
     */
    public final TableField<Record, Integer> INVENTORY_ID = createField(DSL.name("inventory_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>rental.customer_id</code>.
     */
    public final TableField<Record, Short> CUSTOMER_ID = createField(DSL.name("customer_id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>rental.return_date</code>.
     */
    public final TableField<Record, LocalDateTime> RETURN_DATE = createField(DSL.name("return_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>rental.staff_id</code>.
     */
    public final TableField<Record, Short> STAFF_ID = createField(DSL.name("staff_id"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>rental.last_update</code>.
     */
    public final TableField<Record, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * Create a <code>rental</code> table reference
     */
    public Rental() {
        this(DSL.name("rental"), null);
    }

    /**
     * Create an aliased <code>rental</code> table reference
     */
    public Rental(String alias) {
        this(DSL.name(alias), RENTAL);
    }

    /**
     * Create an aliased <code>rental</code> table reference
     */
    public Rental(Name alias) {
        this(alias, RENTAL);
    }

    private Rental(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Rental(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Rental(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, RENTAL);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.IDX_FK_INVENTORY_ID, Indexes.IDX_UNQ_RENTAL_RENTAL_DATE_INVENTORY_ID_CUSTOMER_ID, Indexes.RENTAL_PKEY);
    }

    @Override
    public Identity<Record, Integer> getIdentity() {
        return Keys.IDENTITY_RENTAL;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.RENTAL_PKEY;
    }

    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.RENTAL_PKEY);
    }

    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.RENTAL__RENTAL_INVENTORY_ID_FKEY, Keys.RENTAL__RENTAL_CUSTOMER_ID_FKEY, Keys.RENTAL__RENTAL_STAFF_ID_KEY);
    }

    public Inventory inventory() {
        return new Inventory(this, Keys.RENTAL__RENTAL_INVENTORY_ID_FKEY);
    }

    public Customer customer() {
        return new Customer(this, Keys.RENTAL__RENTAL_CUSTOMER_ID_FKEY);
    }

    public Staff staff() {
        return new Staff(this, Keys.RENTAL__RENTAL_STAFF_ID_KEY);
    }

    @Override
    public Rental as(String alias) {
        return new Rental(DSL.name(alias), this);
    }

    @Override
    public Rental as(Name alias) {
        return new Rental(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Rental rename(String name) {
        return new Rental(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Rental rename(Name name) {
        return new Rental(name, null);
    }
}
