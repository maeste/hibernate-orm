/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2012, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.internal.source.annotations.attribute;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.metamodel.spi.source.ManyToManyPluralAttributeElementSource;
import org.hibernate.metamodel.spi.source.PluralAttributeElementNature;
import org.hibernate.metamodel.spi.source.RelationalValueSource;

/**
 * @author Hardy Ferentschik
 */
public class ManyToManyPluralAttributeElementSourceImpl implements ManyToManyPluralAttributeElementSource {
	private final PluralAssociationAttribute associationAttribute;

	public ManyToManyPluralAttributeElementSourceImpl(PluralAssociationAttribute associationAttribute) {
		this.associationAttribute = associationAttribute;
	}

	@Override
	public String getReferencedEntityName() {
		return associationAttribute.getReferencedEntityType();
	}

	@Override
	public String getReferencedEntityAttributeName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public List<RelationalValueSource> getValueSources() {
		List<RelationalValueSource> valueSources = new ArrayList<RelationalValueSource>();
		// todo
		return valueSources;
	}

	@Override
	public boolean isNotFoundAnException() {
		return !associationAttribute.isIgnoreNotFound();
	}

	@Override
	public String getExplicitForeignKeyName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isUnique() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getOrderBy() {
		return associationAttribute.getOrderBy();
	}

	@Override
	public String getWhere() {
		return associationAttribute.getWhereClause();
	}

	@Override
	public FetchMode getFetchMode() {
		return associationAttribute.getFetchMode();
	}

	@Override
	public boolean fetchImmediately() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PluralAttributeElementNature getNature() {
		return PluralAttributeElementNature.MANY_TO_MANY;
	}
}


